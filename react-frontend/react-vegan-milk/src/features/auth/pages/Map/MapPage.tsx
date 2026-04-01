import { useEffect, useState } from "react";

import { fetchMachinesForMap } from "@/api/api";
import { MachineMapResponse } from "@/api/types";
import { MapScreen } from "@/components/ui/Map/MapScreen";

export function MapPage() {
  const [machines, setMachines] = useState<MachineMapResponse[]>([]);
  const [selected, setSelected] = useState<MachineMapResponse | null>(null);

  useEffect(() => {
    fetchMachinesForMap({ onlyActive: true }).then((data) => {
      setMachines(data);
      setSelected(data[0] ?? null);
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
