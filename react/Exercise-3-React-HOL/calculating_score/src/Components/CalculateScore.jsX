import "../Stylesheets/mystyle.css";

const getPercentage = (marks, maxMarks) => {
  return ((marks / maxMarks) *100).toFixed(2) + "%";
};

function CalculateScore({ Name, School, Total, goal }) {
  return (
    <div className="student-box">
      <h2>Student Report</h2>

      <p>
        <strong>Name:</strong> {Name}
      </p>

      <p>
        <strong>School:</strong> {School}
      </p>

      <p>
        <strong>Total Marks:</strong> {Total}
      </p>

      <p>
        <strong>Percentage:</strong> {getPercentage(Total, goal)}
      </p>
    </div>
  );
}

export default CalculateScore;