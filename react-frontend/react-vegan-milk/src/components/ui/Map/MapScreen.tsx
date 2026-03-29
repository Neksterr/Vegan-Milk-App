import { useState } from 'react';
import type { LocationItem } from '../types';
import { MapView } from './MapView';
import { TopBar } from './TopBar';
import { BottomCard } from './BottomCard';
import { BottomNav } from './BottomNav';

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