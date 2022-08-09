public class kehutuijian {
    public static void main(String[] args) {
        int cunkuan = 2;
        int xinyongka = 3;
        boolean isxinyongka=true;
        double licai = 0;
        boolean shoujiyinhang = true;
        String kaihuhang = "beixia";

//条件优先级  kaihuhang > cunkuan > shoujiyinhang = isxinyongka = licai
        if (kaihuhang == "beixia"){
            if ((shoujiyinhang==true)&(isxinyongka==true)&(licai>0)&(cunkuan>=20)){
                System.out.println("完美客户");
            }else {
                System.out.println("全面关系客户：你还差");
                if (shoujiyinhang == false){
                    System.out.println("老师，你可以办理我行的手机银行，以后你没事就可以不用来烦我们了");
                }

                if (isxinyongka==false){
                    System.out.println("信用卡予审批客户：老师，你是我行的信用卡预审批客户，可以送你一张额度"+xinyongka+"w的 银行卡，您申请吗");
                }
                if (cunkuan < 20){
                    System.out.println("AUM：存点钱过来");
                }
            }
        }else {
            System.out.println("非本网点客户，推荐建行生活");
        }

    }
}
