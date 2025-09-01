// Song list
let songs = [];

// Fetch songs dynamically from JSON file
fetch('songs.json')
    .then(response => response.json())
    .then(data => {
        songs = data;
        initPlayer();
        loadPlaylist();
        loadFavorites();
        loadRecentlyPlayed();
    })
    .catch(error => console.error("Error loading songs:", error));


// Variables
let audio = new Audio();
let currentIndex = 0;
let isPlaying = false;
let shuffleMode = false;
let repeatMode = false;
let favorites = JSON.parse(localStorage.getItem('favorites')) || [];
let recentlyPlayed = JSON.parse(localStorage.getItem('recentlyPlayed')) || [];

// DOM Elements
const playlistContainer = document.getElementById('playlist');
const nowPlayingTitle = document.getElementById('nowPlayingTitle');
const nowPlayingCover = document.getElementById('nowPlayingCover');
const playPauseBtn = document.getElementById('playPause');
const progressBar = document.getElementById('progressBar');
const currentTimeEl = document.getElementById('currentTime');
const totalDurationEl = document.getElementById('totalDuration');
const volumeSlider = document.getElementById('volumeSlider');
const favoritesList = document.getElementById('favoritesList');
const recentlyPlayedList = document.getElementById('recentlyPlayedList');

// Load playlist with favorites
function loadPlaylist() {
    playlistContainer.innerHTML = '';
    songs.forEach((song, index) => {
        let div = document.createElement('div');
        div.classList.add('song-item');
        div.innerHTML = `
            <img src="${song.cover}" alt="${song.title}">
            <p><b>${song.title}</b></p>
            <small>${song.artist}</small><br>
            <small>${song.duration}</small>
            <button class="fav-btn" onclick="toggleFavorite(${index}, event)">
                <i class="fa ${favorites.includes(index) ? 'fa-heart' : 'fa-heart-o'}"></i>
            </button>
`;

        div.onclick = (e) => {
            if (!e.target.closest('.fav-btn')) playSong(index);
        };
        playlistContainer.appendChild(div);
    });
}

// Play song
function playSong(index) {
    currentIndex = index;
    audio.src = songs[index].file;
    nowPlayingTitle.textContent = `${songs[index].title} - ${songs[index].artist}`;
    nowPlayingTitle.textContent = songs[index].title;
    nowPlayingCover.src = songs[index].cover;
    audio.play();
    isPlaying = true;
    playPauseBtn.innerHTML = '<i class="fa fa-pause"></i>';
    nowPlayingCover.classList.add('playing');
    addToRecentlyPlayed(index);
}

// Play/Pause toggle
function togglePlayPause() {
    if (isPlaying) {
        audio.pause();
        isPlaying = false;
        playPauseBtn.innerHTML = '<i class="fa fa-play"></i>';
        nowPlayingCover.classList.remove('playing');
    } else {
        audio.play();
        isPlaying = true;
        playPauseBtn.innerHTML = '<i class="fa fa-pause"></i>';
        nowPlayingCover.classList.add('playing');
    }
}

// Next/Previous
function nextSong() {
    if (shuffleMode) {
        currentIndex = Math.floor(Math.random() * songs.length);
    } else {
        currentIndex = (currentIndex + 1) % songs.length;
    }
    playSong(currentIndex);
}

function prevSong() {
    currentIndex = (currentIndex - 1 + songs.length) % songs.length;
    playSong(currentIndex);
}

// Progress bar update
function updateProgress() {
    progressBar.value = (audio.currentTime / audio.duration) * 100 || 0;
    let mins = Math.floor(audio.currentTime / 60);
    let secs = Math.floor(audio.currentTime % 60);
    currentTimeEl.textContent = `${mins}:${secs < 10 ? '0' : ''}${secs}`;
}

function setProgress() {
    audio.currentTime = (progressBar.value / 100) * audio.duration;
}

function updateDuration() {
    let mins = Math.floor(audio.duration / 60);
    let secs = Math.floor(audio.duration % 60);
    totalDurationEl.textContent = `${mins}:${secs < 10 ? '0' : ''}${secs}`;
}

// Volume
function setVolume() {
    audio.volume = volumeSlider.value;
}

// Recently Played
function addToRecentlyPlayed(index) {
    recentlyPlayed = recentlyPlayed.filter(i => i !== index);
    recentlyPlayed.unshift(index);
    if (recentlyPlayed.length > 5) recentlyPlayed.pop();
    localStorage.setItem('recentlyPlayed', JSON.stringify(recentlyPlayed));
    loadRecentlyPlayed();
}

function loadRecentlyPlayed() {
    recentlyPlayedList.innerHTML = '';
    recentlyPlayed.forEach(index => {
        let li = document.createElement('li');
        li.textContent = songs[index].title;
        recentlyPlayedList.appendChild(li);
    });
}

// Favorites
function toggleFavorite(index, event) {
    event.stopPropagation();
    if (favorites.includes(index)) {
        favorites = favorites.filter(i => i !== index);
    } else {
        favorites.push(index);
    }
    localStorage.setItem('favorites', JSON.stringify(favorites));
    loadPlaylist();
    loadFavorites();
}

function loadFavorites() {
    favoritesList.innerHTML = '';
    favorites.forEach(index => {
        let li = document.createElement('li');
        li.textContent = songs[index].title;
        favoritesList.appendChild(li);
    });
}

// Search
function searchSongs() {
    let query = document.getElementById('searchInput').value.toLowerCase();
    playlistContainer.innerHTML = '';
    songs.forEach((song, index) => {
        if (song.title.toLowerCase().includes(query)) {
            let div = document.createElement('div');
            div.classList.add('song-item');
            div.innerHTML = `
                <img src="${song.cover}">
                <p>${song.title}</p>
                <small>${song.duration}</small>
                <button class="fav-btn" onclick="toggleFavorite(${index}, event)">
                    <i class="fa ${favorites.includes(index) ? 'fa-heart' : 'fa-heart-o'}"></i>
                </button>
            `;
            div.onclick = (e) => {
                if (!e.target.closest('.fav-btn')) playSong(index);
            };
            playlistContainer.appendChild(div);
        }
    });
}

// Voice search
function voiceSearch() {
    let recognition = new (window.SpeechRecognition || window.webkitSpeechRecognition)();
    recognition.onresult = (event) => {
        document.getElementById('searchInput').value = event.results[0][0].transcript;
        searchSongs();
    };
    recognition.start();
}

// Event listeners
document.getElementById('playPause').onclick = togglePlayPause;
document.getElementById('next').onclick = nextSong;
document.getElementById('prev').onclick = prevSong;
progressBar.oninput = setProgress;
audio.ontimeupdate = updateProgress;
audio.onloadedmetadata = updateDuration;
volumeSlider.oninput = setVolume;
document.getElementById('searchInput').oninput = searchSongs;
document.getElementById('voiceSearch').onclick = voiceSearch;

// Song end behavior
audio.onended = () => {
    if (repeatMode) {
        playSong(currentIndex);
    } else {
        nextSong();
    }
};

// Init player with first song
function initPlayer() {
    currentIndex = 0;
    audio.src = songs[currentIndex].file;
    nowPlayingTitle.textContent = songs[currentIndex].title;
    nowPlayingCover.src = songs[currentIndex].cover;
    nowPlayingCover.classList.remove('playing');

    audio.addEventListener('loadedmetadata', () => {
        updateDuration();
    });
}

// Visitor Counter
let visits = localStorage.getItem('visits') || 0;
visits++;
localStorage.setItem('visits', visits);
document.body.insertAdjacentHTML(
    'beforeend', 
    `<p style="text-align:center; padding:10px; color:#aaa;">Visitor Count: ${visits}</p>`
);



