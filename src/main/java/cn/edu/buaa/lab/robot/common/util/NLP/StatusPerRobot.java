package cn.edu.buaa.lab.robot.common.util.NLP;

public class StatusPerRobot {

    //每次要重置
    public int recommendIndex = -1;
    public int weather_time = -3;
    public String weather_city = "";
    //以下需要每个机器单独发送状态
    public boolean isSleep = false;
    public String input = "";
    public boolean waitNext = false;

    public StatusPerRobot(boolean isSleep, boolean waitNext,String input){
        this.recommendIndex = -1;
        this.weather_city = "";
        this.weather_time = -3;
        this.isSleep = isSleep;
        this.waitNext = waitNext;
        this.input = input;
    }

    public int getRecommendIndex() {
        return recommendIndex;
    }

    public void setRecommendIndex(int recommendIndex) {
        this.recommendIndex = recommendIndex;
    }

    public int getWeather_time() {
        return weather_time;
    }

    public void setWeather_time(int weather_time) {
        this.weather_time = weather_time;
    }

    public String getWeather_city() {
        return weather_city;
    }

    public void setWeather_city(String weather_city) {
        this.weather_city = weather_city;
    }

    public boolean isSleep() {
        return isSleep;
    }

    public void setSleep(boolean sleep) {
        isSleep = sleep;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public boolean isWaitNext() {
        return waitNext;
    }

    public void setWaitNext(boolean waitNext) {
        this.waitNext = waitNext;
    }

}
