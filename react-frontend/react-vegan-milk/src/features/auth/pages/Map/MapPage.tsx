import { useEffect, useState } from "react";

import { MapScreen } from "../components/ui/Map/MapScreen";
import type { MachineMapResponse } from "../types";

export function MapPage() {
  const [machines, setMachines] = useState<MachineMapResponse[]>([]);
  const [selected, setSelected] = useState<MachineMapResponse | null>(null);

  useEffect(() => {
    fetchMachinesForMap({ onlyActive: true }).then((data) => {
      setMachines(data);
      setSelected(data[0] ?? null);``
    });
  }, []);

  if (!selected) return <div>Loading...</div>;

  return (
    <MapScreen
      locations={machines}
      selected={selected}
      onSelect={setSelected}
    />
  );
}