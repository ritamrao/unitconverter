package com.example.unitconverter;



public class conversionMethod {
    public String lengthUnits(String inputUnit, String units, int value){
        double output;
        output = 0;
        switch (inputUnit){
            case "inch" :
            {
                switch (units){
                    case "inch" : output = value; break;
                    case "yard" : output = value/36.0;break;
                    case "metre" :  output = value/39.37;break;
                    case "km" : output = value/39370.0; break;
                    case "mile" : output = value/63360.0;break;
                }
            }break;
            case "yard" :
            {
                switch (units){
                    case "inch" : output = value*36; break;
                    case "yard" : output = value; break;
                    case "metre" :  output = value/1.094; break;
                    case "km" : output = value/1094.0; break;
                    case "mile" : output = value/1760.0; break;
                }
                break;
            }
            case "metre" :
            {
                switch (units){
                    case "inch" : output = value*39.37; break;
                    case "yard" : output = value*1.094; break;
                    case "metre" :  output = value; break;
                    case "km" : output = value/1000.0; break;
                    case "mile" : output = value/1609.0; break;
                }
                break;
            }
            case "km" :
            {
                switch (units){
                    case "inch" : output = value*39370.0; break;
                    case "yard" : output = value*1094.0; break;
                    case "metre" :  output = value*1000.0; break;
                    case "km" : output = value; break;
                    case "mile" : output = value/1.609; break;
                }
                break;
            }
            case "mile" :
            {
                switch (units){
                    case "inch" : output = value*63360.0; break;
                    case "yard" : output = value*1760.0; break;
                    case "metre" :  output = value*1609; break;
                    case "km" : output = value*1.609; break;
                    case "mile" : output = value; break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + units);
                }
                break;
            }
        }
        return output + units;
    }

    public String weightUnits(String inputUnit, String units, int value){
        double output;
        output = 0;
        switch (inputUnit){
            case "kg" :
            {
                switch (units){
                    case "kg" : output = value; break;
                    case "lbs" : output = value*2.205; break;
                    case "ounce" :  output = value*35.274; break;
                    case "ton" : output = value/1000.0; break;
                }
                break;
            }
            case "lbs" :
            {
                switch (units){
                    case "kg" : output = value/2.205; break;
                    case "lbs" : output = value; break;
                    case "ounce" :  output = value*16; break;
                    case "ton" : output = value/2205.0; break;
                }
                break;
            }
            case "ounce" :
            {
                switch (units){
                    case "kg" : output = value/35.274; break;
                    case "lbs" : output = value/16.0; break;
                    case "ounce" :  output = value; break;
                    case "ton" : output = value/35274.0; break;
                }
                break;
            }
            case "ton" :
            {
                switch (units){
                    case "kg" : output = value*1000.0; break;
                    case "lbs" : output = value*2205.0; break;
                    case "ounce" :  output = value*35274.0; break;
                    case "ton" : output = value; break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + units);
                }
                break;
            }
        }
        return output + units;
    }

    public String tempUnits(String inputUnit, String units, int value) {
        double output;
        output = 0;
        switch (inputUnit){
            case "Kelvin" :
            {
                switch (units){
                    case "Kelvin" : output = value; break;
                    case "Celsius" : output = value - 273.15; break;
                    case "Fahrenheit" :  output = (value - 273.15) * 9/5 + 32; break;
                }
                break;
            }
            case "Celsius" :
            {
                switch (units){
                    case "Kelvin" : output = value + 273.15; break;
                    case "Celsius" : output = value; break;
                    case "Fahrenheit" :  output = (value * 9/5 + 32.0); break;
                }
                break;
            }
            case "Fahrenheit" :
            {
                switch (units){
                    case "Kelvin" : output = ((value - 32.0) * 5/9 + 273.15); break;
                    case "Celsius" : output = (value - 32.0) * 5/9; break;
                    case "Fahrenheit" :  output = value; break;
                }
                break;
            }
        }
        return output + units;
    }
}
