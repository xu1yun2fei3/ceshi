interface Phone{
    String salePhone();
}

class Huawei implements Phone{
    @Override
    public String salePhone() {
        return "华为手机";
    }
}

class Vivo implements Phone{
    @Override
    public String salePhone() {
        return "Vivo手机";
    }
}

class Xiaomi implements Phone{
    @Override
    public String salePhone() {
        return "小米手机";
    }
}

