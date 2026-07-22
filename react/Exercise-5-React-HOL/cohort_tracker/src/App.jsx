import "./App.module.css";
import { CohortsData } from "./Cohort";
import CohortDetails from "./Cohort_details";

function App() {
  return (
    <div>
      <h1>Cohorts Details</h1>

      {CohortsData.map((cohort) => (
        <CohortDetails
          key={cohort.cohortCode}
          cohort={cohort}
        />
      ))}
    </div>
  );
}

export default App;