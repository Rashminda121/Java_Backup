package net.codejava;

import com.paypal.base.rest.PayPalRESTException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "authorize_payment", value = "/authorize_payment")
public class AuthorizePaymentServlet extends HttpServlet {

    private static final long serialVersionUID=1L;
    public AuthorizePaymentServlet() {
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String product = request.getParameter("product");
        String subtotal = request.getParameter("subtotal");
        String shipping = request.getParameter("shipping");
        String tax = request.getParameter("tax");
        String total = request.getParameter("total");

        OrderDetail orderDetail = new OrderDetail(product, subtotal, shipping, tax, total);

        try {
            PaymentServices paymentServices = new PaymentServices();
            String approvalLink = paymentServices.authorizePayment(orderDetail);

            response.sendRedirect(approvalLink);

        } catch (PayPalRESTException ex) {
            request.setAttribute("errorMessage", "Invalid Payment Details");
            ex.printStackTrace();

            request.getRequestDispatcher("jsp/error.jsp").forward(request, response);
        }
    }
}
