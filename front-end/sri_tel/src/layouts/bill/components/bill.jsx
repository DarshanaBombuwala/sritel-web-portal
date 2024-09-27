import React from 'react';

const Bill = ({ description, amount }) => {
  return (
    <div>
      <p><strong>Description:</strong> {description}</p>
      <p><strong>Amount:</strong> ${amount}</p>
      <hr />
    </div>
  );
};

export default Bill;
