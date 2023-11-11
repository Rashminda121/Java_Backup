package net.codejava;

import com.paypal.api.payments.PayerInfo;
import com.paypal.api.payments.Payment;
import com.paypal.api.payments.ShippingAddress;
import com.paypal.api.payments.Transaction;
import com.paypal.base.rest.PayPalRESTException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "review_payment", value = "/review_payment")
public class ReviewPaymentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ReviewPaymentServlet() {
        super();
    }

    //getting payer id and payment id from url
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        String paymentId = request.getParameter("paymentId");
        String payerId =request.getParameter("PayerID");

        try{
            PaymentServices paymentServices= new PaymentServices();
            Payment payment= paymentServices.getPaymentDetails(payerId);

            PayerInfo payerInfo= payment.getPayer().getPayerInfo();
            Transaction transaction= payment.getTransactions().get(0);
            ShippingAddress shippingAddress =transaction.getItemList().getShippingAddress();

            request .setAttribute("payer",payerInfo);
            request .setAttribute("transaction",transaction);
            request .setAttribute("shippingAddress",shippingAddress);

            String url= "review.jsp?paymnetId=" + paymentId + "&PayerID="+payerId;
            request.getRequestDispatcher(url).forward(request,response);
        }
        catch (PayPalRESTException ex) {

            ex.printStackTrace();
            request.setAttribute("errorMessage", "Could not get Payment Details.");
            request.getRequestDispatcher("jsp/error.jsp").forward(request, response);
        }
    }
}
