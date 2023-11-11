package net.codejava;

import com.paypal.api.payments.*;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;

import java.util.ArrayList;
import java.util.List;


//payment receiving sandbox account details need to change to live and change the mode to "live"
public class PaymentServices {
    //paypal rest api apps client id Sandbox
    private static final String CLIENT_ID = "AVHltGk1oH5MDHZCRUcZPm8IZ3Gm8IG5MQUEQfyWXr-mZuI_sLQGEjArXfBz4gjSR_idsupOHAnprPwv";
    //paypal rest api apps secret code
    private static final String CLIENT_SECRET = "EGFhvD2h_-6k1sC3tFng6b-2eHPB9sHWAHDw75lFzj1QPjBVeK9tIhItX8vt9rCGtnM6TrE_Mkw1TTSC";
    private static final String MODE = "sandbox";

    public String authorizePayment(OrderDetail orderDetail) throws PayPalRESTException {
        Payer payer =getPayerInformation();
        RedirectUrls redirectUrls =getRedirectURLs();

        List<Transaction> listTransaction= getTransactionInformation(orderDetail);

        Payment requestPayment= new Payment();
        requestPayment.setTransactions(listTransaction)
                      .setRedirectUrls(redirectUrls)
                      .setPayer(payer)
                      .setIntent("authorize");

        APIContext apiContext= new APIContext(CLIENT_ID,CLIENT_SECRET,MODE);
         Payment approvedPayment=requestPayment.create(apiContext);

        System.out.println(approvedPayment);

        return getApprovalLink(approvedPayment);
    }


    private String getApprovalLink(Payment approvedPayment){
        List<Links> links = approvedPayment.getLinks();

        String approvalLink=null;

        for (Links link : links){
            if(link.getRel().equalsIgnoreCase("approval_url")){
                approvalLink=link.getHref();
            }
        }
        return approvalLink;
    }
    private List<Transaction> getTransactionInformation(OrderDetail orderDetail){

        Details details = new Details();
        details.setShipping(orderDetail.getShipping());
        details.setSubtotal(orderDetail.getSubtotal());
        details.setTax(orderDetail.getTax());

        Amount amount=new Amount();     //amount
        amount.setCurrency("USD");// currency
        amount.setTotal(orderDetail.getTotal());// total
        amount.setDetails(details);

        Transaction transaction=new Transaction(); // transaction
        transaction.setAmount(amount); //getting amount
        transaction.setDescription(orderDetail.getProductName());// getting product details

        ItemList itemList= new ItemList();
        List<Item> items=new ArrayList<>();

        Item item= new Item();
        item.setCurrency("USD")
            .setName(orderDetail.getProductName())
            .setPrice(orderDetail.getSubtotal())
            .setTax(orderDetail.getTax())
            .setQuantity("1");

        items.add(item);
        itemList.setItems(items);
        transaction.setItemList(itemList);

        List<Transaction> listTransaction=new ArrayList<>();
        listTransaction.add(transaction);


        return listTransaction;
    }

    private RedirectUrls getRedirectURLs() {
        RedirectUrls redirectUrls= new RedirectUrls();
        redirectUrls.setCancelUrl("http://localhost:8080/html/cancel.html"); // user cancellation
        redirectUrls.setReturnUrl("http://localhost:8080/html/review_payment");

        return redirectUrls;
    }


    public Payment getPaymentDetails(String paymentId ) throws PayPalRESTException {
        APIContext apiContext = new APIContext(CLIENT_ID,CLIENT_SECRET,MODE);
        return Payment.get(apiContext,paymentId);
    }

    public Payment executePayment(String paymentId,String payerId) throws PayPalRESTException {
        PaymentExecution paymentExecution= new PaymentExecution();
        paymentExecution.setPayerId(payerId);

        Payment payment= new Payment().setId(paymentId);
        APIContext apiContext = new APIContext(CLIENT_ID,CLIENT_SECRET,MODE);

        return payment.execute(apiContext,paymentExecution);
    }

    private Payer getPayerInformation() {

        Payer payer=new Payer();
        payer.setPaymentMethod("Paypal");

        PayerInfo payerInfo = new PayerInfo();

        payerInfo.setFirstName("FirstName")
                 .setLastName("LastName")
                 .setEmail("example@company.com");

        payer.setPayerInfo(payerInfo);

        return payer;
    }



}


