package GenericsTemplateProgramming;

public class StorageLocker<T> {
    private int lockerNumber;
    private boolean isLocked;
    private T item;

    public StorageLocker(int lockerNumber, T item){
        this.lockerNumber = lockerNumber;
        this.isLocked = true;
        this.item = item;
    }

    public int getLockerNumber(){ return this.lockerNumber; }
    public void setLockerNumber(int lockerNumber){ this.lockerNumber = lockerNumber; }
    public T getItem(){ return this.item; }
    public void setItem(T item){ this.item = item; }

    public void unlock(){ this.isLocked = false; }
    public void lock(){ this.isLocked = true; }
    public void viewItem(){
        if (isLocked){
            System.out.println("Locker " + this.lockerNumber + " is locked. Cannot view items.");
        } else {
            System.out.println("Locker: " + this.lockerNumber + " contains: " + this.item);
        }
    }
}

class Main {
    public static void main(String[] args) {
        StorageLocker<String> locker = new StorageLocker<>(42, "Secret Map");
        locker.viewItem();                 // Locker 42 is locked. Cannot view items.

        locker.unlock();
        locker.viewItem();                 // Locker 42 contains: Secret Map

        locker.lock();
        locker.viewItem();                 // Locker 42 is locked. Cannot view items.

        locker.unlock();
        locker.setItem("Diamond");
        System.out.println("New item: " + locker.getItem()); // New item: Diamond
        locker.viewItem();                 // Locker 42 contains: Diamond
    }
}
