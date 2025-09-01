package Assignments.Polymorphism;


    class TicketBooking {
        private String stageEvent;
        private String customer;
        private Integer noOfSeats;

        // Default constructor
        public TicketBooking() {}

        // Parameterized constructor
        public TicketBooking(String stageEvent, String customer, Integer noOfSeats) {
            this.stageEvent = stageEvent;
            this.customer = customer;
            this.noOfSeats = noOfSeats;
        }

        // Getters and Setters
        public String getStageEvent() {
            return stageEvent;
        }

        public void setStageEvent(String stageEvent) {
            this.stageEvent = stageEvent;
        }

        public String getCustomer() {
            return customer;
        }

        public void setCustomer(String customer) {
            this.customer = customer;
        }

        public Integer getNoOfSeats() {
            return noOfSeats;
        }

        public void setNoOfSeats(Integer noOfSeats) {
            this.noOfSeats = noOfSeats;
        }

        // Overloaded methods for different payments

        // 1) Cash payment
        public void makePayment(Double amount) {
            System.out.printf("Amount %.1f paid in cash\n", amount);
        }

        // 2) Wallet payment
        public void makePayment(String walletNumber, Double amount) {
            System.out.printf("Amount %.1f paid using wallet number %s\n", amount, walletNumber);
        }

        // 3) Credit card payment
        public void makePayment(String creditCard, String ccv, String name, Double amount) {
            System.out.println("Holder name:" + name);
            System.out.printf("Amount %.1f paid using %s card\n", amount, creditCard);
            System.out.println("CCV:" + ccv);
        }
    }


