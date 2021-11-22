package com.upgrad.patterns.Service;

import com.upgrad.patterns.Constants.SourceType;
import com.upgrad.patterns.Interfaces.IndianDiseaseStat;
import com.upgrad.patterns.Strategies.DiseaseShStrategy;
import com.upgrad.patterns.Strategies.JohnHopkinsStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.upgrad.patterns.Constants.SourceType.DiseaseSh;
import static com.upgrad.patterns.Constants.SourceType.JohnHopkins;

@Service
public class IndiaDiseaseStatFactory {
    private IndianDiseaseStat diseaseShStrategy;
    private IndianDiseaseStat johnHopkinsStrategy;

    @Autowired
    public IndiaDiseaseStatFactory(DiseaseShStrategy diseaseShStrategy, JohnHopkinsStrategy johnHopkinsStrategy)
    {
        this.diseaseShStrategy = diseaseShStrategy;
        this.johnHopkinsStrategy = johnHopkinsStrategy;
    }

    //create a method named GetInstance with return type as IndianDiseaseStat and parameter of type sourceType
    public IndianDiseaseStat GetInstance(SourceType sourceType) {
        //create a conditional statement
        //if the sourceType is JohnHopkins
        //return johnHopkinsStrategy
        if (sourceType == JohnHopkins) {
            return johnHopkinsStrategy;
        }
        //if the sourceType is DiseaseSh
        //return diseaseShStrategy
        else if (sourceType == DiseaseSh){
            return diseaseShStrategy;
        }else {
            //create a message for invalid disease strategy/sourceType
            //throw the message as an Illegal argument exception
            throw new IllegalArgumentException("invalid disease strategy/sourceType.");
        }

    }
    
}
