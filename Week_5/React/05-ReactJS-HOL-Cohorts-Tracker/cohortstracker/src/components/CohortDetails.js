import './CohortDetails.css';

function CohortDetails(props) {
  const cohort = props.cohort;

  const headingStyle = {
    color: cohort.status === 'Ongoing' ? 'green' : 'blue'
  };

  return (
    <div className="cohort-card">
      <h3 style={headingStyle}>{cohort.name}</h3>

      <dl>
        <dt>Cohort Code</dt>
        <dd>{cohort.code}</dd>

        <dt>Technology</dt>
        <dd>{cohort.technology}</dd>

        <dt>Status</dt>
        <dd>{cohort.status}</dd>

        <dt>Start Date</dt>
        <dd>{cohort.startDate}</dd>
      </dl>
    </div>
  );
}

export default CohortDetails;
