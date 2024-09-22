import React, { useState } from 'react';
import Bill from './components/bill'; // Import the Bill component

const bills = [
  { id: 1, type: 'Current', description: 'yoyoyooy', amount: 100 },
  { id: 2, type: 'Previous', description: 'yoyoyooy', amount: 50 },

];

const BillsPage = () => {
  const [searchTerm, setSearchTerm] = useState('');

  const filteredBills = bills.filter(bill =>
    bill.description.toLowerCase().includes(searchTerm.toLowerCase())
  );

  return (
    <div>
      <h2>Bills Page</h2>
      <input
        type="text"
        placeholder="Search bills"
        value={searchTerm}
        onChange={(e) => setSearchTerm(e.target.value)}
      />
      <div>
        <h3>Current Bills</h3>
        {filteredBills.filter(bill => bill.type === 'Current').map(bill => (
          <Bill
            key={bill.id}
            description={bill.description}
            amount={bill.amount}
          />
        ))}
        <h3>Previous Bills</h3>
        {filteredBills.filter(bill => bill.type === 'Previous').map(bill => (
          <Bill
            key={bill.id}
            description={bill.description}
            amount={bill.amount}
          />
        ))}
      </div>
    </div>
  );
};

export default BillsPage;
