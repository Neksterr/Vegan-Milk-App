import { useEffect, useRef } from 'react';
import maplibregl, { type Map, type Marker } from 'maplibre-gl';
import { LocationItem } from '@/api/types';

type Props = {
  locations: LocationItem[];
  selectedId: number;
  theme: 'eco' | 'light' | 'streets';
  onSelect: (item: LocationItem) => void;
};

const THEMES: Record<Props['theme'], string> = {
  eco: 'https://basemaps.cartocdn.com/gl/voyager-gl-style/style.json',
  light: 'https://basemaps.cartocdn.com/gl/positron-gl-style/style.json',
  streets: 'https://demotiles.maplibre.org/style.json',
};

export function MapView({ locations, selectedId, theme, onSelect }: Props) {
  const containerRef = useRef<HTMLDivElement | null>(null);
  const mapRef = useRef<Map | null>(null);
  const markersRef = useRef<Marker[]>([]);

  useEffect(() => {
    if (!containerRef.current || mapRef.current) {
      return;
    }

    const initial = locations.find((item) => item.id === selectedId) ?? locations[0];

    const map = new maplibregl.Map({
      container: containerRef.current,
      style: THEMES[theme],
      center: [initial.lng, initial.lat],
      zoom: 15.3,
      attributionControl: false,
    });

    map.addControl(new maplibregl.NavigationControl({ showCompass: false }), 'top-right');

    mapRef.current = map;

    return () => {
      markersRef.current.forEach((marker) => marker.remove());
      markersRef.current = [];
      map.remove();
      mapRef.current = null;
    };
  }, [locations, selectedId, theme]);

  useEffect(() => {
    const map = mapRef.current;
    if (!map) {
      return;
    }

    const style = THEMES[theme];
    const currentStyle = map.getStyle()?.sprite;
    if (currentStyle === undefined || !map.isStyleLoaded() || map.getStyle()?.name !== style) {
      map.setStyle(style);
    }
  }, [theme]);

  useEffect(() => {
    const map = mapRef.current;
    if (!map) {
      return;
    }

    markersRef.current.forEach((marker) => marker.remove());
    markersRef.current = [];

})}