const T20Players = [
  "First Player",
  "Second Player",
  "Third Player",
];

const RanjiPlayers = [
  "Fourth Player",
  "Fifth Player",
  "Sixth Player",
];

export const IndianPlayers = [...T20Players, ...RanjiPlayers];

export function OddPlayers({ players }) {
  const [first, , third, , fifth] = players;

  return (
    <div>
      <ul>
        <li>First : {first}</li>
        <li>Third : {third}</li>
        <li>Fifth : {fifth}</li>
      </ul>
    </div>
  );
}

export function EvenPlayers({ players }) {
  const [, second, , fourth, , sixth] = players;

  return (
    <div>
      <ul>
        <li>Second : {second}</li>
        <li>Fourth : {fourth}</li>
        <li>Sixth : {sixth}</li>
      </ul>
    </div>
  );
}

export function ListofIndianPlayers({ IndianPlayers }) {
  return (
    <div>
      <ul>
        {IndianPlayers.map((player, index) => (
          <li key={index}>Mr. {player}</li>
        ))}
      </ul>
    </div>
  );
}