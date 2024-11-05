import React, { useEffect, useState } from 'react';
import Service from './components/service'; // Import the Service component
import axios from 'axios';
import '../../App.css';

const services = [
  { id: 1, name: 'Roaming service', description: 'International Roaming service when travelling abroad', cost: 'LKR 250.00'},
  { id: 2, name: 'Ring-in Tone', description: 'Ring-in Tone personalisation', cost: 'LKR 100.00'},
  { id: 3, name: '1GB Data', description: 'Get 1GB data top up', cost: 'LKR 200.00' },
  { id: 4, name: '500MB Data', description: 'Get 500MB data top up', cost: 'LKR 100.00' },
  { id: 5, name: 'News Alert', description: 'Get latest news alerts', cost: 'LKR 300.00' },
  { id: 6, name: '100min any net', description: 'Get 100min to talk any network', cost: 'LKR 200.00' },
];

const ServicesPage = () => {

  const [allServices, setAllServices] = useState(services)

  useEffect(() => {
    const getSubscribedService = async () => {
      await axios.get('http://localhost:8081/SUBSCRIPTION_SERVICE/api/subscription/get')
        .then(response => {
          if(response.status===200){
            response.data && setAllServices(
              allServices.map(service => (
                {...service, sub: response.data.includes(service.id)}
              ))
            )
          }
        })
        .catch(error => {

        })
    }

    getSubscribedService()
  }, [])

  return (
    <div className="services-container">
      <h2 className="services-title">Our Services</h2>
      <div className="services-list">
        {services.map(service => (
          <Service
            key={service.id}
            name={service.name}
            description={service.description}
            cost={service.cost}
            sub={service.sub}
          />
        ))}
      </div>
    </div>
  );
};

export default ServicesPage;
