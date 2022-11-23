package com.myapp;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClientBuilder;
import com.amazonaws.services.simpleemail.model.*;

import java.util.List;

public class App {

    //public static void main(String[] args) {
      //  process();
    //}

    public static void process(){
        String sender = "cristian.cardozo@ticketmaster.com";
        List<String> recipient = List.of("cristian.cardozo@ticketmaster.com");
        String subject = "Test SES - From Java";
        String emailContent ="Hola mundo!!!";

        try{
            SendEmailRequest sendEmailRequest = new SendEmailRequest()
                    .withDestination(new Destination().withToAddresses(recipient))
                    .withMessage(new Message().withBody(new Body().withText(new Content().withData(emailContent)))
                            .withSubject(new Content().withData(subject)))
                    .withSource(sender);

            AmazonSimpleEmailService ses = AmazonSimpleEmailServiceClientBuilder.standard()
                    //.withCredentials(new ProfileCredentialsProvider("tm-nonprod-Ops-Techops"))
                    .withRegion(Regions.US_EAST_1.getName()).build();

            ses.sendEmail(sendEmailRequest);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
  }
