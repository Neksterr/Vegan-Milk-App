import type { MachineMapRequest, MachineMapResponse } from "./types";

const API_BASE = "http://localhost:8080";

export async function fetchMachinesForMap(
  request: MachineMapRequest
): Promise<MachineMapResponse[]> {
  const response = await fetch(`${API_BASE}/api/machines/map`, {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(request),
  });

  if (!response.ok) {
    throw new Error("Failed to load machines");
  }

  return response.json();
}