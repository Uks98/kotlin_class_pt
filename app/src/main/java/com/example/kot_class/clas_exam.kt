package com.example.kot_class

fun main(){
    var car1 : Car = Car("빨강",300)
    car1.upSpeed(30)
    println("속도는" + car1.speed + "이며 색상은" + car1.color + "입니다.")
    var car2 : Car = Car(20)
    car2.upSpeed(30)
    //상속받은 클래스 사용
    var autoMobile : AutoMobile = AutoMobile()
    autoMobile.upSpeed(300)
    println("이 차량의 최고속도는" + autoMobile.speed + "입니다.")

    println("car2 속도는" + car2.speed + "이며 색상은" + car2.color + "입니다.")
    println("생산된 차의 대수" + Car.carCount)
    println("생산된 차의 최고속도" + Car.MAXSPEED)
    println("생산된 차의 최저속도" + Car.MINSPEED)
}

open class Car{
    //open은 상속 허용을 위한 키워드 함수도 마찬가지
    var color : String = ""
    var speed : Int = 0

    //생성자 생성하기,파라미터 값 받기위해
    constructor(color : String,speed : Int){
        this.color = color
        this.speed = speed
        carCount ++
    }
    //메소드 오버로딩(한 클래스 내에서 메소드의 이름이 같아도 파라미터의 개수나 데이터 타입으로 구분)
    constructor(speed: Int){
        this.speed = speed
    }
    constructor(){}
    //정적필드,정적메소드,상수필드 인스턴스를 생성하지 않아도 호출이 가능하다.
    companion object{
    var carCount : Int = 0
        const val MAXSPEED : Int = 200
        const val MINSPEED : Int = 0
        fun currentCount():Int{
            return carCount
        }
    }

   open fun upSpeed(value : Int){
        if(speed + value >= 200){
            speed = 200
        }else if(color == ""){
            color = "검정"
        }else{
            speed = speed - value
        }
    }
}

class AutoMobile : Car {
    var seatNum : Int = 0

    constructor(){}
    fun countSeatNum() : Int{
        return  seatNum
    }
    //override 키워드를 사용해 함수를 상속받는다.
    override fun upSpeed(value: Int){
        if(speed + value >= 300){
            speed = 300
        }else if(color == ""){
            color = "검정"
        }else{
            speed = speed + value
        }
    }
}