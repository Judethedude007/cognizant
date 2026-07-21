function UserPage() {
  const flights = [
    { flightNo: 'AI-202', from: 'Chennai', to: 'Delhi', time: '08:30 AM' },
    { flightNo: '6E-305', from: 'Bangalore', to: 'Mumbai', time: '11:00 AM' },
    { flightNo: 'UK-707', from: 'Hyderabad', to: 'Pune', time: '04:45 PM' }
  ];

  const bookTicket = flightNo => {
    alert('Ticket booked for flight ' + flightNo);
  };

  return (
    <div className="page-card">
      <h2>Welcome User</h2>
      <p>You can now book your flight tickets.</p>

      <h3>Book Flights</h3>

      <table>
        <thead>
          <tr>
            <th>Flight No</th>
            <th>From</th>
            <th>To</th>
            <th>Time</th>
            <th>Booking</th>
          </tr>
        </thead>
        <tbody>
          {flights.map(flight => (
            <tr key={flight.flightNo}>
              <td>{flight.flightNo}</td>
              <td>{flight.from}</td>
              <td>{flight.to}</td>
              <td>{flight.time}</td>
              <td>
                <button onClick={() => bookTicket(flight.flightNo)}>
                  Book Ticket
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default UserPage;
