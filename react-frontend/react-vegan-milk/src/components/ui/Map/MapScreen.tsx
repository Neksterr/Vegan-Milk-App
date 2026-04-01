import { useState } from 'react';
import { MapView } from './MapView';
import { LocationItem } from '@/api/types';
import { BottomNav } from '../Menu/BottomNav';

type Props = {
  locations: LocationItem[];
  selected: LocationItem;
  onSelect: (item: LocationItem) => void;
};

type MapTheme = 'eco' | 'light' | 'streets';

export function MapScreen({ locations, selected, onSelect }: Props) {
  const [theme, setTheme] = useState<MapTheme>('eco');

  return (
    <div className="mobile-app">
      <MapView
        locations={locations}
        selectedId={selected.id}
        theme={theme}
        onSelect={onSelect}
      />

      <div className="top-overlay">
        <TopBar theme={theme} onThemeChange={setTheme} />
      </div>

      <div className="card-overlay">
        <BottomCard item={selected} />
      </div>

      <div className="nav-overlay">
        <BottomNav />
      </div>
    </div>
  );
}