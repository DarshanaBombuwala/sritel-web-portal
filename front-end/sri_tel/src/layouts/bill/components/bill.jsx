import React from 'react';

const Bill = ({ description, amount, createdDate }) => {
  return (
    <div>
      <p><strong>Created Date:</strong> {createdDate}</p>
      <p><strong>Description:</strong> {description}</p>
      <p><strong>Amount:</strong> ${amount}</p>
      <hr />
    </div>
  );
};

export default Bill;
