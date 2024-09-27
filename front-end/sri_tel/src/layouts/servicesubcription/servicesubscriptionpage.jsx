import React from 'react';
import Service from './components/service'; // Import the Service component

const services = [
  { id: 1, name: 'Roaming service', description: 'International Roaming service when travelling abroad', cost: 'LKR 250.00'},
  { id: 2, name: 'Ring-in Tone', description: 'Ring-in Tone personalisation', cost: 'LKR 100.00'},
  { id: 3, name: '1GB Data', description: 'Get 1GB data top up', cost: 'LKR 200.00' },
  { id: 3, name: '500MB Data', description: 'Get 500MB data top up', cost: 'LKR 100.00' },
  { id: 3, name: 'News Alert', description: 'Get latest news alerts', cost: 'LKR 300.00' },
  { id: 3, name: '100min any net', description: 'Get 100min to talk any network', cost: 'LKR 200.00' },
];

const ServicesPage = () => {
  return (
    <div>
      <h2>Our Services</h2>
      <div>
        {services.map(service => (
          <Service
            key={service.id}
            name={service.name}
            description={service.description}
            cost={service.cost}
          />
        ))}
      </div>
    </div>
  );
};

export default ServicesPage;
