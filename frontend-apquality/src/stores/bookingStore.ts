import { create } from "zustand"

interface bookingState {
  bookedTime: Date | null,
  details: string,
  clientName: string,
  clientAddress: string,
  clientPhone: string,
  bookingType: string,
  serviceList: string[]

  setBookedTime: (date: Date) => void,
  setDetails: (details: string) => void,
  setClientName: (name: string) => void,
  setClientPhone: (phone: string) => void,
  setBookingType: (bookingType: string) => void,
  setServiceList: (serviceList: string[]) => void
}

export const useBookingStore = create<bookingState>(set => ({
  bookedTime: null,
  details: '',
  clientName: '',
  clientAddress: '',
  clientPhone: '',
  bookingType: '',
  serviceList: [],

  setBookedTime: (date) => set({ bookedTime: date }),
  setDetails: (details) => set({ details: details }),
  setClientName: (name) => set({ clientName: name }),
  setClientPhone: (phone) => set({ clientPhone: phone }),
  setBookingType: (bookingType) => set({ bookingType: bookingType }),
  setServiceList: (serviceList) => set({ serviceList: serviceList })
}))