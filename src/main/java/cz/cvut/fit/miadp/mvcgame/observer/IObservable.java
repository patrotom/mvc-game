package cz.cvut.fit.miadp.mvcgame.observer;

public interface IObservable {
    public void registerObserver(IObserver observer);
    public void unregisterObserver(IObserver observer);
    public void notifyObservers();
}
