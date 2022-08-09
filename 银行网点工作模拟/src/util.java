class util {
    public static void yuangognxingxi(YuanGong yuanGong) {
        System.out.println((String.format("%s: 热情度：%d 心情：%s", yuanGong.getMingzi(), yuanGong.getReqing(), yuanGong.getXinqing() == true ? "高兴" : "沮丧")));
    }

    public static YuanGong[] shangbanrenyuan(String renyuanmingdan) {
        String[] mingdan = renyuanmingdan.split(",");
        YuanGong[] shangbanrenyuan = new YuanGong[mingdan.length - 1];
        for (int i = 0; i < mingdan.length - 1; i++) {
            shangbanrenyuan[i] = new YuanGong(i, mingdan[i], "gaogui", (int) (Math.random() * 10 + 5));
        }
        return shangbanrenyuan;
    }
}
