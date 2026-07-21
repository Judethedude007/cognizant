import './App.css';

function App() {
  const officeSpaces = [
    {
      id: 1,
      name: 'DBS Business Center',
      rent: 50000,
      address: 'Chennai',
      image: 'https://images.unsplash.com/photo-1497366754035-f200968a6e72'
    },
    {
      id: 2,
      name: 'Tech Park Workspace',
      rent: 75000,
      address: 'Bangalore',
      image: 'https://images.unsplash.com/photo-1497366811353-6870744d04b2'
    },
    {
      id: 3,
      name: 'Modern Office Hub',
      rent: 60000,
      address: 'Hyderabad',
      image: 'https://images.unsplash.com/photo-1497366216548-37526070297c'
    }
  ];

  return (
    <div className="App">
      <h1>Office Space, at Affordable Range</h1>

      <div className="office-container">
        {officeSpaces.map(office => {
          const rentStyle = {
            color: office.rent <= 60000 ? 'red' : 'green'
          };

          return (
            <div className="office-card" key={office.id}>
              <img src={office.image} alt={office.name} />
              <h2>Name: {office.name}</h2>
              <h3 style={rentStyle}>Rent: Rs. {office.rent}</h3>
              <h3>Address: {office.address}</h3>
            </div>
          );
        })}
      </div>
    </div>
  );
}

export default App;
