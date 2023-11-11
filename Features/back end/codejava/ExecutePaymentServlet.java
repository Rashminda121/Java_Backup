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

@WebServlet(name = "execute_payment", value = "/execute_payment")
public class ExecutePaymentServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    public ExecutePaymentServlet() {
        super();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String paymentId=request.getParameter("paymentId");
        String payerId=request.getParameter("PayerID");

       try{
            PaymentServices paymentServices= new PaymentServices();
            Payment payment= paymentServices.executePayment(paymentId,payerId);

           PayerInfo payerInfo= payment.getPayer().getPayerInfo();
           Transaction transaction= payment.getTransactions().get(0);

           request .setAttribute("payer",payerInfo);
           request .setAttribute("transaction",transaction);

           request.getRequestDispatcher("jsp/receipt.jsp").forward(request,response);

       }
       catch (PayPalRESTException ex) {

           ex.printStackTrace();
           request.setAttribute("errorMessage", "Could not Execute Payment.");
           request.getRequestDispatcher("jsp/error.jsp").forward(request, response);
       }
    }
}
