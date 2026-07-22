import CalculateScore from "./Components/CalculateScore";

function App() {
  return (
    <div>
      <CalculateScore
        Name="Saurav"
        School="UPS Public School"
        Total={100}
        goal={3}
      />
    </div>
  );
}

export default App;