class PhoneProxy implements Phone {
    private Phone phone;

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    @Override
    public String salePhone() {
        System.out.println("静态代理卖手机");
        return this.phone.salePhone();
    }
}
