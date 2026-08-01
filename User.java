class User{
    private int user_id;
    private String name;
    private long phone_num;
    private String email;
    public static int idcounter=100;

    

    User(String name,long phone_num,String email){
        this.name=name;
        this.phone_num=phone_num;
        this.email=email;

    }
    void setUserId(){
        user_id=idcounter++;
    }
    

    int getId(){
        return user_id;
    }

    String getName(){
        return name;
    }
    long getPhoneNum(){
        return phone_num;
    }
    String emailId(){
        return email;
    }





}