export type LocationItem = {
  id: number;
  name: string;
  subtitle: string;
  lat: number;
  lng: number;
  etaMinutes: number;
  distanceMeters: number;
  price: number;
  productName: string;
  productDescription: string;
  productImage: string;
  accentColor: string;
};
export type MachineMapRequest = {
  onlyActive: boolean;
};

export type MachineMapResponse = {
  id: number;
  name: string;
  subtitle: string;
  lat: number;
  lng: number;
};