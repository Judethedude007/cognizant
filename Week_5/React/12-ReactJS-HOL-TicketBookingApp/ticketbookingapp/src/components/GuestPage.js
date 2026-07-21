function GuestPage() {
  const flights = [
    { flightNo: 'AI-202', from: 'Chennai', to: 'Delhi', time: '08:30 AM' },
    { flightNo: '6E-305', from: 'Bangalore', to: 'Mumbai', time: '11:00 AM' },
    { flightNo: 'UK-707', from: 'Hyderabad', to: 'Pune', time: '04:45 PM' }
  ];

  return (
    <div className="page-card">
      <h2>Welcome Guest</h2>
      <p>You can view available flight details below.</p>

      <h3>Available Flights</h3>

      <table>
        <thead>
          <tr>
            <th>Flight No</th>
            <th>From</th>
            <th>To</th>
            <th>Time</th>
          </tr>
        </thead>
        <tbody>
          {flights.map(flight => (
            <tr key={flight.flightNo}>
              <td>{flight.flightNo}</td>
              <td>{flight.from}</td>
              <td>{flight.to}</td>
              <td>{flight.time}</td>
            </tr>
          ))}
        </tbody>
      </table>

      <p className="note">Please login to book tickets.</p>
    </div>
  );
}

export default GuestPage;
