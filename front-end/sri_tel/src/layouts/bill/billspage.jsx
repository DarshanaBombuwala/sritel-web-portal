import React, { useEffect, useState } from 'react';
import Bill from './components/bill'; // Import the Bill component
import axios from 'axios';

const bill = [
  { id: 1, type: 'Current', description: 'yoyoyooy', amount: 100 },
  { id: 2, type: 'Previous', description: 'yoyoyooy', amount: 50 },

];

const BillsPage = () => {
  const [searchTerm, setSearchTerm] = useState('');
  const [bills, setBills] = useState(bill)

  useEffect(() => {
    const getBills = async () => {
      await axios.get('http://localhost:8081/BILL_SERVICE/bill')
      .then(response => {
        if(response.status===200) setBills(response.data)
      })
      .catch(error => {

      })
    }

    getBills()
  }, [])

  const [bills, setBills] = useState([])

  useState(() => {
    const getBills = async () => {
      axios.get('')
        .then(response => {
          if(response.status===200) setBills(response.data)
        })
        .catch(error => {

        })
    }

    getBills()
  }, [])

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
        {filteredBills.filter(bill => bill.billStatus === 'PENDING').map(bill => (
          <Bill
            key={bill.id}
            description={bill.serviceName}
            amount={bill.amount}
            createdDate={bill.createdDate}
            pay={true}
          />
        ))}
        <h3>Previous Bills</h3>
        {filteredBills.filter(bill => bill.type !== 'PENDING').map(bill => (
          <Bill
            key={bill.id}
            description={bill.serviceName}
            amount={bill.amount}
            createdDate={bill.createdDate}
        />
        ))}
      </div>
    </div>
  );
};

export default BillsPage;
