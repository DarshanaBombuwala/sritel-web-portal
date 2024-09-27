import React from 'react';
import Service from './components/service'; // Import the Service component

const services = [
  { id: 1, name: 'Service 1', description: 'Description for Service 1' },
  { id: 2, name: 'Service 2', description: 'Description for Service 2' },
  { id: 3, name: 'Service 3', description: 'Description for Service 3' },
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
          />
        ))}
      </div>
    </div>
  );
};

export default ServicesPage;
