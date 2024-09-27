import React from 'react';
import { useNavigate } from 'react-router-dom';

const Bill = ({ key, description, amount, createdDate, pay }) => {

  const navigate = useNavigate()

  const handlePay = () => {
    navigate('/payments', {state: { id: key }})
  }

  return (
    <div>
      <p><strong>Created Date:</strong> {createdDate}</p>
      <p><strong>Description:</strong> {description}</p>
      <p><strong>Amount:</strong> ${amount}</p>
      {pay && <button onClick={handlePay}>Pay Now</button>}
      <hr />
    </div>
  );
};

export default Bill;
