package DesignPatterns;

//Adapter
public interface EuropeanSocket {
    void provideElectricity();
}

class USPlug{
    public void connectToUSOutlet(){
        System.out.println("US PLUG");
    };
}

class SocketAdapter implements EuropeanSocket{
    private USPlug usPlug;

    public SocketAdapter(USPlug usPlug){
        this.usPlug = usPlug;
    }

    @Override
    public void provideElectricity(){
        System.out.println("Converts european to us");
        usPlug.connectToUSOutlet();
    }
}

class AdapterDemo {
    public static void main(String[] args) {
        USPlug usPlug = new USPlug();
        EuropeanSocket adapter = new SocketAdapter(usPlug);
        adapter.provideElectricity();
    }
}