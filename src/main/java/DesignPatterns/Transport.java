package DesignPatterns;

//Factory
public interface Transport {
    void deliver();
}

class Truck implements Transport{
    @Override
    public void deliver(){
        System.out.println("Delivering by land");
    }
}

class Ship implements Transport{
    @Override
    public void deliver(){
        System.out.println("Delivering by sea");
    }
}

class TransportFactory{
    public Transport createTransport(String type){
        switch (type.toLowerCase()){
            case "truck":
                return new Truck();
            case "ship":
                return new Ship();
        }
        return null;
    }
}

class FactoryDemo {
    public static void main(String[] args) {
        TransportFactory factory = new TransportFactory();

        Transport land = factory.createTransport("truck");
        Transport sea = factory.createTransport("ship");

        land.deliver();   // Delivering by land in a truck.
        sea.deliver();    // Delivering by sea in a ship.
    }
}