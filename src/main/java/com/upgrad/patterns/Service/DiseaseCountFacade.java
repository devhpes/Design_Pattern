package com.upgrad.patterns.Service;

import com.upgrad.patterns.Constants.SourceType;
import com.upgrad.patterns.Interfaces.IndianDiseaseStat;
import org.springframework.stereotype.Service;

import static com.upgrad.patterns.Constants.SourceType.DiseaseSh;
import static com.upgrad.patterns.Constants.SourceType.JohnHopkins;

@Service
public class DiseaseCountFacade {

   //create a private object indiaDiseaseStat of type IndiaDiseaseStatFactory
    private IndiaDiseaseStatFactory indiaDiseaseStat;

    //create a public method getDiseaseShCount() that has Object as its return type
    //call the GetInstance method with DiseaseSh as the parameter using the indiaDiseaseStat object created on line 10
    //Based on the strategy returned, call the specific implementation of the GetActiveCount method
    //return the response

    public Object getDiseaseShCount(){
        IndianDiseaseStat indianDiseaseStat = indiaDiseaseStat.GetInstance(DiseaseSh);
        return indianDiseaseStat.GetActiveCount();

    }
    //create a public method getJohnHopkinCount() that has Object as its return type
    //call the GetInstance method with JohnHopkins as the parameter using the indiaDiseaseStat object created on line 10
    //Based on the strategy returned, call the specific implementation of the GetActiveCount method
    //return the response

    public Object getJohnHopkinCount(){
        IndianDiseaseStat indianDiseaseStat = indiaDiseaseStat.GetInstance(JohnHopkins);
        return indianDiseaseStat.GetActiveCount();
    }

    public Object getInfectedRatio(String sourceType) throws IllegalArgumentException {
        try {
            Float population = 900000000F;
            SourceType sourceEnum = SourceType.valueOf(sourceType);
            Float active = Float.valueOf(indiaDiseaseStat.GetInstance(sourceEnum).GetActiveCount());
            Float percent = Float.valueOf((active / population));
            return String.format("%.3f", percent * 100);
        }
        catch (Exception e) {
            String message = String.format("Invalid source type specified. Available source type (%s, %s)", DiseaseSh, SourceType.JohnHopkins);
            throw new IllegalArgumentException(message);
        }
    }

}
