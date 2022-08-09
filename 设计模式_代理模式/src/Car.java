interface Car{
    String saleCar();
}

class Baoma implements Car{
    @Override
    public String saleCar() {
        return "宝马汽车";
    }
}

class Dazhong implements Car{
    @Override
    public String saleCar() {
        return "大众汽车";
    }
}


