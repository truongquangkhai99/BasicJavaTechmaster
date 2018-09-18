package com.company;

class Television { //Có thể tách class ra 1 file riêng
    int channel;//Đây là 1 trường = field
    int volumeChannel = 1;//Trường có giá trị mặc định ban đầu
    boolean isOn = false;//Mặc định là tắt
    //constructor = "Hàm khởi tạo", gọi khi khởi tạo đối tượng
    public Television(int channel, int volumeChannel, boolean isOn) {//Tên hàm trùng với tên class
        System.out.println("This is a Constructor");
        this.channel = channel;
        this.volumeChannel = volumeChannel;
        this.isOn = isOn;
    }
    //Định nghĩa 1 phương thức(method)
    void showDetail() {
        System.out.println("Detail object: Channel: "+
                this.channel+", volumeLevel: "+this.volumeChannel+
                ", isOn: "+this.isOn);
    }
}