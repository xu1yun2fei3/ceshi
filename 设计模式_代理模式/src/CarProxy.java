class CarProxy implements Car {
    private Car Car;

    public void setCar(Car Car) {
        this.Car = Car;
    }

    @Override
    public String saleCar() {
        System.out.println("静态代理代理卖汽车");
        return this.Car.saleCar();
    }
}
