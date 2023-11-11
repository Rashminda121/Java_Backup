
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Payment Receipt</title>

    <style type="text/css">
        table { border: 0; }
        table td { padding: 10px; }
    </style>
</head>
<body align=center>

<div align="center">
    <h1>Payment Done,</h1>
    <h1>Thank You for Purchasing our products.</h1>
    <h2>Receipt Details:</h2>
    <br/>

        <table>
            <tr>
                <td>Merchent:</td>
                <td>Company ABC Ltd.</td>
            </tr>
            <tr>
                <td>Payer:</td>
                <td>${payer.firstName} ${payer.lastName}</td>
            </tr>

            <tr>
                <td>Description:</td>
                <td>{transaction.description}</td>
            </tr>
            <tr>
                <td>Subtotal:</td>
                <td>{transaction.amount.details.subtotal}</td>
            </tr>
            <tr>
                <td>Shipping:</td>
                <td>{transaction.amount.details.shipping}</td>
            </tr>
            <tr>
                <td>Tax:</td>
                <td>{transaction.amount.details.tax}</td>
            </tr>
            <tr>
                <td>Total:</td>
                <td>{transaction.amount.total}</td>
            </tr>

            <tr><td><br></td></tr>



        </table>

</div>

</body>
</html>
