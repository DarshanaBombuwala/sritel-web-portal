import axios from 'axios';
import React, { useState } from 'react';
import '../../App.css';

const PaymentsPage = () => {
  const [cardNumber, setCardNumber] = useState('');
  const [cardName, setCardName] = useState('');
  const [expiryDate, setExpiryDate] = useState('');
  const [cvv, setCvv] = useState('');
  const [amount, setAmount] = useState('');

  const { id } = location.state || {};

  const handleSubmit = async(e) => {
    e.preventDefault();
    
    await axios.post('http://localhost:8081/PAYMENT_SERVICE/pay/bill', {cardNumber: cardNumber, cardName: cardName, expiryDate: expiryDate, cvv: cvv, amount: amount, serviceId: id})
      .then(response => {
        if(response.status===200){
          
        }
      })
      .catch(error => {

      })

    alert('Payment Submitted!');
  };

  return (
    <div className="payment-form-container">
      <h2 className="payment-form-title">Pay for Bills Online</h2>
      <form onSubmit={handleSubmit} className="payment-form">
        <div className="form-group">
          <label htmlFor="cardNumber">Card Number:</label>
          <input
            type="text"
            id="cardNumber"
            value={cardNumber}
            onChange={(e) => setCardNumber(e.target.value)}
            placeholder="1234 5678 9123 4567"
            required
          />
        </div>
        <div className="form-group">
          <label htmlFor="cardName">Cardholder Name:</label>
          <input
            type="text"
            id="cardName"
            value={cardName}
            onChange={(e) => setCardName(e.target.value)}
            placeholder="John Doe"
            required
          />
        </div>
        <div className="form-group">
          <label htmlFor="expiryDate">Expiry Date:</label>
          <input
            type="text"
            id="expiryDate"
            value={expiryDate}
            onChange={(e) => setExpiryDate(e.target.value)}
            placeholder="MM/YY"
            required
          />
        </div>
        <div className="form-group">
          <label htmlFor="cvv">CVV:</label>
          <input
            type="text"
            id="cvv"
            value={cvv}
            onChange={(e) => setCvv(e.target.value)}
            placeholder="123"
            required
          />
        </div>
        <div className="form-group">
          <label htmlFor="amount">Amount:</label>
          <input
            type="text"
            id="amount"
            value={amount}
            onChange={(e) => setAmount(e.target.value)}
            placeholder="100.00"
            required
          />
        </div>
        <button type="submit" className="payment-button">Pay Now</button>
      </form>
    </div>
  );
};

export default PaymentsPage;
