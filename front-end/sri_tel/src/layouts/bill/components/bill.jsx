import React from 'react';
import '../../../App.css';

const Bill = ({ description, amount, createdDate }) => {
  return (
    <div className="bill">
      <p className="bill-date"><strong>Created Date:</strong> {createdDate}</p>
      <p className="bill-description"><strong>Description:</strong> {description}</p>
      <p className="bill-amount"><strong>Amount:</strong> ${amount}</p>
      <hr className="bill-divider" />
    </div>
  );
};

export default Bill;
