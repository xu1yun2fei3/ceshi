public interface House {
    String saleHouse();
}

class BigHouse implements House{
    @Override
    public String saleHouse() {
        return "买大房子";
    }
}
