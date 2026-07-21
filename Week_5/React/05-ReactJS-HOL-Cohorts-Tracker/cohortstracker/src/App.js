import './App.css';
import CohortDetails from './components/CohortDetails';

function App() {
  const cohorts = [
    {
      code: 'DN5.0-JavaFSE-001',
      name: 'Java FSE Cohort 1',
      technology: 'Java Full Stack Engineer',
      status: 'Ongoing',
      startDate: '22-Jun-2026'
    },
    {
      code: 'DN5.0-React-002',
      name: 'React Cohort 2',
      technology: 'React',
      status: 'Completed',
      startDate: '15-Jun-2026'
    },
    {
      code: 'DN5.0-Spring-003',
      name: 'Spring Boot Cohort 3',
      technology: 'Spring Boot',
      status: 'Ongoing',
      startDate: '01-Jul-2026'
    }
  ];

  return (
    <div className="App">
      <h1>Cohorts Tracker</h1>

      {cohorts.map(cohort => (
        <CohortDetails key={cohort.code} cohort={cohort} />
      ))}
    </div>
  );
}

export default App;
