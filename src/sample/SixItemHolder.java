package sample;

public class SixItemHolder {


    String text1;
    String text2;
    String text3;
    String text4;
    String text5;
    String text6;

    public SixItemHolder(){}
    public SixItemHolder( String text01, String text02,String text03,String text04,String text05,String text06  )
    {this.text1=text01;
     this.text2=text02;
     this.text3=text03;
     this.text4=text04;
     this.text5=text05;
     this.text6=text06;}

    public String showErything()
    {return getText1()+" "+getText2()+" "+getText3()+" "+getText4()+" "+getText5()+" "+getText6();}


    public String getText1() {
        return text1;
    }

    public void setText1(String text1) {
        this.text1 = text1;
    }

    public String getText2() {
        return text2;
    }

    public void setText2(String text2) {
        this.text2 = text2;
    }

    public String getText3() {
        return text3;
    }

    public void setText3(String text3) {
        this.text3 = text3;
    }

    public String getText4() {
        return text4;
    }

    public void setText4(String text4) {
        this.text4 = text4;
    }

    public String getText5() {
        return text5;
    }

    public void setText5(String text5) {
        this.text5 = text5;
    }

    public String getText6() {
        return text6;
    }

    public void setText6(String text6) {
        this.text6 = text6;
    }
}
