package DesignPatterns;

//Builder
public class Pizza {
    private final String size;
    private final boolean cheese;
    private final boolean pepperoni;
    private final boolean bacon;

    private Pizza(Builder builder){
        this.size = builder.size;
        this.cheese = builder.cheese;
        this.pepperoni = builder.pepperoni;
        this.bacon = builder.bacon;
    }

    public static class Builder{
        private String size = "medium";
        private boolean cheese = false;
        private boolean pepperoni = false;
        private boolean bacon = false;

        public Builder setSize(String size){
            this.size = size;
            return this;
        }

        public Builder addCheese(){
            this.cheese = true;
            return this;
        }

        public Builder addPepperoni() {
            this.pepperoni = true;
            return this;
        }

        public Builder addBacon() {
            this.bacon = true;
            return this;
        }

        public Pizza build() {
            return new Pizza(this);
        }
    }

    @Override
    public String toString(){
        return "Pizza {" + "size='" + size + '\'' + ", cheese=" + cheese + ", pepperoni=" + pepperoni + ", bacon=" + bacon + '}';
    }

    public static void main(String[] args) {
        Pizza pizza1 = new Pizza.Builder()
                .setSize("large")
                .addCheese()
                .addPepperoni()
                .build();

        Pizza pizza2 = new Pizza.Builder()
                .addBacon()
                .build();

        Pizza pizza3 = new Pizza.Builder()
                .setSize("small")
                .addCheese()
                .addPepperoni()
                .addBacon()
                .build();

        System.out.println(pizza1);
        System.out.println(pizza2);
        System.out.println(pizza3);
    }
}
